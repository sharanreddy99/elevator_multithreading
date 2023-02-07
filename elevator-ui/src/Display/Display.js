import React from "react";

import CheckBoxOutlineBlankIcon from "@mui/icons-material/CheckBoxOutlineBlank";
import ArrowCircleUpIcon from "@mui/icons-material/ArrowCircleUp";
import ArrowCircleDownIcon from "@mui/icons-material/ArrowCircleDown";
import { FormControl, Input, InputAdornment, InputLabel } from "@mui/material";

const Display = ({ display }) => {
  return (
    <>
      <FormControl variant="standard" sx={{ width: "150px" }}>
        <InputLabel htmlFor="input-with-icon-adornment">
          Elevator - {display["elevator"]}
        </InputLabel>
        <Input
          disabled
          id="input-with-icon-adornment"
          startAdornment={
            <InputAdornment position="start">
              {display["direction"] === "UP" ? (
                <ArrowCircleUpIcon />
              ) : display["direction"] === "DOWN" ? (
                <ArrowCircleDownIcon />
              ) : (
                <CheckBoxOutlineBlankIcon />
              )}
            </InputAdornment>
          }
          value={display["floor"]}
        />
      </FormControl>
    </>
  );
};

export default Display;
