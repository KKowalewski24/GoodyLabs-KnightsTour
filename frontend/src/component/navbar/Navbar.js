import React from "react";
import propTypes from "prop-types";
import {Link} from "react-router-dom";
import {PATH_HOME} from "../../constants";
import {Switch, Typography} from "@material-ui/core";
import WbSunnyIcon from "@material-ui/icons/WbSunny";
import NightsStayIcon from "@material-ui/icons/NightsStay";
import "../../index.css";
import GlobalStyles from "../../main/GlobalStyles";

export const Navbar = (props) => {

  /*----------------------- VARIABLE REGION -----------------------*/
  const globalStyles = GlobalStyles();

  const renderThemeToggler = () => {
    return (
      <div className="mr-auto">
        <WbSunnyIcon/>
        <Switch
          checked={props.isDarkMode}
          onChange={props.handleDarkMode}
          color="default"
        />
        <NightsStayIcon/>
      </div>
    );
  };

  const renderContent = () => {
    return (
      props.children
    );
  };

  /*------------------------ RETURN REGION ------------------------*/
  return (
    <>
      <nav className={"navbar navbar-expand-lg navbar-dark text-white "
      + globalStyles.materialBlueBackground}>
        <Link to={PATH_HOME} className="navbar-brand">
          <Typography className="mr-3" variant="h6" noWrap>
            {props.msg}
          </Typography>
        </Link>

        {renderThemeToggler()}
      </nav>

      {renderContent()}
    </>
  );
};

Navbar.propTypes = {
  msg: propTypes.string.isRequired,
  isDarkMode: propTypes.bool.isRequired,
  handleDarkMode: propTypes.func.isRequired,
};

export default Navbar;