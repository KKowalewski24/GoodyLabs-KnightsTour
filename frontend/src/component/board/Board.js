import React from "react";
import propTypes from "prop-types";
import Cell from "../cell/Cell";

export const Board = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const renderRow = () => {
    return (
      <>
        <Cell/>
        <Cell/>
        <Cell/>
        <Cell/>
        <Cell/>
        <Cell/>
        <Cell/>
        <Cell/>
      </>
    );
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    renderRow()
  );
};

Board.propTypes = {};

export default Board;
    