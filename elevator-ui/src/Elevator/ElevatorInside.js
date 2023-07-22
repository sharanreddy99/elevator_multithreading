import React, { useEffect, useState } from "react";
import {
  Button,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableRow,
  TextField,
} from "@mui/material";
import axios from "axios";
const ElevatorInside = ({ floor, liftSpeed, elevatorId, loopUntillNone }) => {
  const [elevatorObj, setElevatorObj] = useState({
    floor: floor,
    elevatorId: elevatorId,
  });

  const goToFloor = async () => {
    const floorCurrId = elevatorObj.floor;
    const elevatorCurrId = elevatorObj.elevatorId;
    setTimeout(async () => {
      alert(JSON.stringify(elevatorObj));
      await axios.post(
        process.env.REACT_APP_ELEVATOR_MULTITHREADING_BACKEND_HOST + "/lifts/move",
        {
          floor: floorCurrId,
          elevator: elevatorCurrId,
        }
      );
      loopUntillNone();
    }, liftSpeed + 500);
  };

  const changeHandler = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setElevatorObj({ ...elevatorObj, [name]: value });
  };

  useEffect(() => {
    setElevatorObj({
      floor: floor,
      elevatorId: elevatorId,
    });
  }, []);

  return (
    <>
      <TableContainer
        component={Paper}
        sx={{ border: "1px solid black", backgroundColor: "grey" }}
      >
        <Table>
          <TableBody>
            <TableRow>
              <TableCell>
                <TextField
                  id="floor"
                  name="floor"
                  label="Choose destination floor"
                  type="number"
                  value={elevatorObj.floor}
                  onChange={changeHandler}
                />
              </TableCell>

              <TableCell>
                <Button
                  id="initializeButton"
                  name="initializeButton"
                  variant="contained"
                  style={{ marginTop: "1.5%", marginLeft: "1.5%" }}
                  size="large"
                  color="warning"
                  onClick={goToFloor}
                >
                  Move
                </Button>
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>
                <h4>Elevator {elevatorId}</h4>
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default ElevatorInside;
