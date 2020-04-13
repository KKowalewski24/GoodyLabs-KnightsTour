import React from "react";
import propTypes from "prop-types";
import Cell from "../cell/Cell";

export const Board = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const returnProperCellColor = (pointX, pointY) => {
    if (pointY % 2 === 0) {
      if (pointX % 2 === 0) {
        return {backgroundColor: "#efebe9"};
      } else if (pointX % 2 === 1) {
        return {backgroundColor: "#795548"};
      }
    } else if (pointY % 2 === 1) {
      if (pointX % 2 === 0) {
        return {backgroundColor: "#795548"};
      } else if (pointX % 2 === 1) {
        return {backgroundColor: "#efebe9"};
      }
    }
  };

  // const makeRow = () => {
  //   return (
  //
  //   );
  // };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    props.boardData.map((it, index) => {
      console.log(index)
      return (
        <Cell
          key={index}
          pointX={it.pointX}
          pointY={it.pointY}
          cellColor={returnProperCellColor(it.pointX, it.pointY)}
          cellValue={it.orderNumber ? it.orderNumber : ""}
          onClickChooseCell={props.onClickChooseCell}
        />
      );
    })
  )
};

Board.propTypes = {
  boardData: propTypes.array.isRequired,
  onClickChooseCell: propTypes.func.isRequired,
};

export default Board;
    