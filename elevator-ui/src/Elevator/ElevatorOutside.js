import React from "react";
import ArrowCircleUpIcon from "@mui/icons-material/ArrowCircleUp";
import ArrowCircleDownIcon from "@mui/icons-material/ArrowCircleDown";
import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableRow,
} from "@mui/material";
import axios from "axios";

const ElevatorOutside = ({ floor, liftSpeed, loopUntillNone }) => {
  const requestLift = async (direction) => {
    setTimeout(async () => {
      await axios.post(
        process.env.REACT_APP_POLLS_VIEWER_BACKEND_HOST + "/lifts/request",
        {
          floor: floor,
          direction: direction,
        }
      );
      loopUntillNone();
    }, liftSpeed + 500);
  };
  return (
    <>
      <TableContainer
        component={Paper}
        sx={{ border: "1px solid black", width: "50" }}
      >
        <Table>
          <TableBody>
            <TableRow>
              <TableCell>
                <ArrowCircleUpIcon
                  onClick={() => {
                    requestLift("UP");
                  }}
                />
              </TableCell>
            </TableRow>
            <TableRow>
              <TableCell>
                <ArrowCircleDownIcon
                  onClick={() => {
                    requestLift("DOWN");
                  }}
                />
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default ElevatorOutside;
