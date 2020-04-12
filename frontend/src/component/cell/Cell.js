import React, {useEffect, useState} from "react";
import propTypes from "prop-types";
import "./Cell.css";

export const Cell = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const [pointX] = useState(props.pointX);
  const [pointY] = useState(props.pointY);
  const [cellColor, setCellColor] = useState({});

  useEffect(() => {
    setCellColor(props.returnProperCellColor(pointX, pointY));
  }, [pointX, pointY]);

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <div className="cell" style={cellColor}
         onClick={() => props.onClickChooseCell(pointX, pointY)}>
      {props.renderOrderNumber()}
    </div>
  );
};

Cell.propTypes = {
  pointX: propTypes.number.isRequired,
  pointY: propTypes.number.isRequired,
  onClickChooseCell: propTypes.func.isRequired,
  renderOrderNumber: propTypes.func.isRequired,
  returnProperCellColor: propTypes.func.isRequired,
};

export default Cell;
    