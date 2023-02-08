import { Alert, Grid } from "@mui/material";
import React, { useEffect, useState } from "react";
import ElevatorInside from "../Elevator/ElevatorInside";
import ElevatorOutside from "../Elevator/ElevatorOutside";
import { v4 as uuidv4 } from "uuid";

const Floor = ({
  floor,
  liftSpeed,
  loopUntillNone,
  nElevators,
  displayArr,
}) => {
  const [floorData, setFloorData] = useState([]);
  useEffect(() => {
    const tempData = [];
    for (let j = 0; j < displayArr.length; j++) {
      if (displayArr[j]["floor"] === floor) {
        tempData.push({ liftPresent: true, elevator: j });
      } else {
        tempData.push({ liftPresent: false, elevator: j });
      }
    }
    setFloorData(tempData);
  }, [displayArr]);

  return (
    <div>
      <Grid container spacing={3}>
        <Grid item>
          <ElevatorOutside
            key={uuidv4()}
            liftSpeed={liftSpeed}
            loopUntillNone={loopUntillNone}
            floor={floor}
          />
        </Grid>
        {floorData.map((data, idx) => {
          if (data["liftPresent"]) {
            return (
              <Grid item>
                <ElevatorInside
                  key={uuidv4()}
                  liftSpeed={liftSpeed}
                  loopUntillNone={loopUntillNone}
                  floor={floor}
                  elevatorId={data.elevator}
                />
              </Grid>
            );
          }
          return <div style={{ width: "400px", height: "200px" }}>.</div>;
        })}
      </Grid>
      <Alert severity="info">Floor - {floor}</Alert>
    </div>
  );
};

export default Floor;
