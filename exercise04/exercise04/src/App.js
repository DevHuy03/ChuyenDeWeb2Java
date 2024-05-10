import React, { Component } from "react";
import { Routes, Route } from "react-router-dom";
import Container from "@mui/material/Container";
import CssBaseline from "@mui/material/CssBaseline";
import MenuTop from "./components/MenuTop";
import Home from "./components/Home";
import Product from "./components/Product";
import EditProduct from "./components/EditProduct";

export default class App extends Component {
  displayName = App.name;

  render() {
    return (
      <React.Fragment>
        <CssBaseline />
        <MenuTop />
        <Container maxWidth="md">
          <Routes>
            <Route exact path="/" element={<Home />} />
            <Route path="/home" element={<Home />} />
            <Route path="/products" element={<Product />} />
            <Route path="/edit/product/:id" element={<EditProduct />} />
          </Routes>
        </Container>
      </React.Fragment>
    );
  }
}
