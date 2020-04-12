import React from "react";
import propTypes from "prop-types";
import "./Cell.css";

export const Cell = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const sample = () => {
    alert("abc")
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <div className="cell" onClick={sample}>

    </div>
  );
};

Cell.propTypes = {};

export default Cell;
    