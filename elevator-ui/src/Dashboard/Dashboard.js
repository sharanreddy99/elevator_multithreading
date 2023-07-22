import { Button, TextField } from "@mui/material";
import { Box } from "@mui/system";
import axios from "axios";
import React, { useState } from "react";
import DisplayBar from "../DisplayBar/DisplayBar";
import Floor from "../Floor/Floor";
import "./Dashboard.css";

const Dashboard = () => {
  const [building, setBuilding] = useState({
    floors: 0,
    elevators: 0,
    floorNumbers: [],
    liftSpeed: 2500,
  });

  const [displayArr, setDisplayArr] = useState([]);

  const buildingInputHandler = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setBuilding({ ...building, [name]: value });
  };

  const initializeBuildingHandler = async () => {
    const resp = await axios.post(
      process.env.REACT_APP_ELEVATOR_MULTITHREADING_BACKEND_HOST +
        "/initializeBuilding",
      building
    );

    const data = { ...resp.data };
    data["floorNumbers"] = Array.from(Array(data["floors"]).keys());
    setBuilding(data);

    if (resp.data?.status === "SUCCESS") {
      const resp = await axios.get(
        process.env.REACT_APP_ELEVATOR_MULTITHREADING_BACKEND_HOST + "/lifts"
      );
      setDisplayArr(resp.data);
    }
  };

  const loopUntillNone = async () => {
    var timer = setInterval(async () => {
      // console.log("Inside loop");
      const resp = await axios.get(
        process.env.REACT_APP_ELEVATOR_MULTITHREADING_BACKEND_HOST + "/lifts"
      );
      let allIdleLifts = resp.data.every((row) => {
        return row["direction"] === "NONE";
      });
      setDisplayArr(resp.data);

      if (allIdleLifts) {
        // console.log("clearing loop");
        clearInterval(timer);
      }
    }, building.liftSpeed);
  };

  return (
    <>
      <Box
        component="form"
        sx={{
          "& .MuiTextField-root": { m: 1, width: "25ch", marginTop: "1%" },
        }}
        noValidate
        autoComplete="off"
      >
        <TextField
          id="floors"
          name="floors"
          label="Enter no of floors"
          type="number"
          value={building.floors}
          onChange={buildingInputHandler}
          InputLabelProps={{
            shrink: true,
          }}
        />
        <TextField
          id="elevators"
          name="elevators"
          label="Enter no of elevators"
          type="number"
          value={building.elevators}
          onChange={buildingInputHandler}
          InputLabelProps={{
            shrink: true,
          }}
        />
        <TextField
          id="liftSpeed"
          name="liftSpeed"
          label="Enter lift duration between floors"
          type="number"
          value={building.liftSpeed}
          onChange={buildingInputHandler}
          InputLabelProps={{
            shrink: true,
          }}
        />

        <Button
          id="initializeButton"
          name="initializeButton"
          variant="contained"
          style={{ marginTop: "1.5%", marginLeft: "1.5%" }}
          size="large"
          color="warning"
          onClick={initializeBuildingHandler}
        >
          Setup Lifts
        </Button>
      </Box>
      <DisplayBar displayArr={displayArr} />
      <div className="base_container">
        {building["floorNumbers"].map((number) => {
          return (
            <Floor
              loopUntillNone={loopUntillNone}
              liftSpeed={building.liftSpeed}
              floor={building.floors - number - 1}
              nElevators={building.elevators}
              displayArr={displayArr}
            />
          );
        })}
      </div>
    </>
  );
};

export default Dashboard;
