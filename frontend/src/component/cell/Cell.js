import React, {useState} from "react";
import propTypes from "prop-types";
import "./Cell.css";
import {Zoom} from "@material-ui/core";

export const Cell = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [pointX] = useState(props.pointX);
  const [pointY] = useState(props.pointY);

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <div
      className="cell" style={props.cellColor}
      onClick={() => props.onClickChooseCell(pointX, pointY)}
    >
      <Zoom in={!!props.cellValue} style={{transitionDelay: !!props.cellValue ? "200ms" : "0ms"}}>
        <h2 className="text-center font-weight-bold black-text">
          {props.cellValue}
        </h2>
      </Zoom>
    </div>
  );
};

Cell.propTypes = {
  pointX: propTypes.number.isRequired,
  pointY: propTypes.number.isRequired,
  cellValue: propTypes.any.isRequired,
  cellColor: propTypes.object.isRequired,
  onClickChooseCell: propTypes.func.isRequired,
};

export default Cell;
    