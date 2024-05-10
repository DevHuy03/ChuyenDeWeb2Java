import React, { useEffect, useState } from "react";
import { makeStyles } from "@mui/styles";
import {
  Alert,
  Button,
  Grid,
  IconButton,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";

import { DELETE_PRODUCT_ID, GET_ALL_PRODUCTS } from "../api/apiService";
import { Link } from "react-router-dom";
import CloseIcon from "@mui/icons-material/IosShare";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    marginTop: 20,
  },
  paper: {
    width: "100%",
    margin: "auto",
  },
  removeLink: {
    textDecoration: "none",
  },
}));
export default function Home() {
  const classes = useStyles();
  const [products, setProducts] = useState({});
  const [checkDeleteProduct, setCheckDeleteProduct] = useState(false);
  const [close, setClose] = useState(false);
  useEffect(() => {
    GET_ALL_PRODUCTS(`products`).then((item) => setProducts(item.data));
  }, []);
  const RawHTML = (body, className) => (
    <div
      className={className}
      dangerouslySetInnerHTML={{ __html: body.replace(/>\n/g, "<br/>") }}
    />
  );
  console.log("row", products);
  const deleteProductID = (id) => {
    DELETE_PRODUCT_ID(`products/${id}`).then((item) => {
      console.log(item);
      if (item.status === 200) {
        setCheckDeleteProduct(true);
        setProducts(products.filter((key) => key.id !== id));
      }
    });
  };
  return (
    <div className={classes.root}>
      <Grid container spacing={3}>
        <Grid item xs={12}>
          <Paper className={classes.paper}>
            {checkDeleteProduct && (
              <Alert
                action={
                  <IconButton
                    aria-label="close"
                    color="inherit"
                    size="small"
                    onClick={() => {
                      setClose(true);
                      setCheckDeleteProduct(false);
                    }}
                  >
                    <CloseIcon fontSize="inherit" />
                  </IconButton>
                }
              >
                Delete successfuly{" "}
              </Alert>
            )}
            <TableContainer component={Paper}>
              <Table className={classes.table} aria-aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell>Title</TableCell>
                    <TableCell align="center">Body</TableCell>
                    <TableCell align="center">Price</TableCell>
                    <TableCell align="center">Modify</TableCell>
                    <TableCell align="center">Delete</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {products.length > 0 &&
                    products.map((row) => (
                      <TableRow key={row.id}>
                        <TableCell component={"th"} scope="row">
                          {row.title}
                        </TableCell>
                        <TableCell align="left">
                          {RawHTML(row.body, "body")}
                        </TableCell>
                        <TableCell align="center">{row.price}</TableCell>
                        <TableCell align="center">
                          <Link
                            to={`/edit/product/${row.id}`}
                            className={classes.removeLink}
                          >
                            <Button
                              size="small"
                              variant="contained"
                              color="primary"
                            >
                              Edit
                            </Button>
                          </Link>
                        </TableCell>
                        <TableCell align="center">
                          <Button
                            size="small"
                            variant="contained"
                            color="secondary"
                            onClick={() => deleteProductID(row.id)}
                          >
                            Remove
                          </Button>
                        </TableCell>
                      </TableRow>
                    ))}
                </TableBody>
              </Table>
            </TableContainer>
          </Paper>
        </Grid>
      </Grid>
    </div>
  );
}
