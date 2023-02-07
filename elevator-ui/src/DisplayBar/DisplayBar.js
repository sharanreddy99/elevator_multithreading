import { Box } from "@mui/system";
import React from "react";
import Display from "../Display/Display";

const DisplayBar = ({ displayArr }) => {
  return (
    <div style={{ width: "100%" }}>
      <Box
        key={"displaybar-box"}
        sx={{
          display: "flex",
          flexWrap: "nowrap",
          p: 1,
          m: 5,
          bgcolor: "background.paper",
          overflow: "scroll",
          borderRadius: 1,
          maxWidth: "90vw",
          boxShadow: "1px 1px 20px 5px grey",
        }}
      >
        {displayArr.map((display, idx) => {
          return (
            <div style={{ marginRight: "30px" }}>
              <Display key={"display" + idx} display={display} />
            </div>
          );
        })}
      </Box>
    </div>
  );
};

export default DisplayBar;
