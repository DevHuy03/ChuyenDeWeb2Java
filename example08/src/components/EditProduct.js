import React, { useEffect, useState } from 'react'
import { makeStyles } from '@mui/styles';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Alert from '@mui/material/Alert';

import { Redirect } from 'react-router-dom';

import { GET_ALL_CATEGORIES, GET_PRODUCT_ID, PUT_EDIT_PRODUCT } from '../api/apiService';
const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
        marginTop: 20
    },
    paper: {
        padding: theme.spacing(2),
        margin: 'auto',
        maxWidth: 600,
    },
    title: {
        fontSize: 30,
        textAlign: 'center'
    },
    link: {
        padding: 10,
        display: 'inline-block'
    },
    txtInput: {
        width: '98%',
        margin: '1%'
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
}));
export default function EditProduct({ match, location }) {
    const classes = useStyles();
    const [checkUpdate, setCheckUpdate] = useState(false);
    const [idProduct, setIdProduct] = useState(0);
    const [title, setTitle] = useState(null)
    const [description, setDescription] = useState(null)
    const [photo, setPhoto] = useState(null)
    const [price, setPrice] = useState(null)
    const [category, setCategory] = useState(0);
    const [categories, setCategories] = useState({});

    useEffect(() => {
        GET_PRODUCT_ID(`products`, match.params.id).then(product => {
            setIdProduct(product.data.id)
            setTitle(product.data.title);
            setDescription(product.data.description);
            setPhoto(product.data.photo);
            setPrice(product.data.price);
            setCategory(product.data.category.id)
        })
        GET_ALL_CATEGORIES('categories').then(item => {
            setCategories(item.data);
        });
    }, [])

    const handleChangeTitle = (event) => {
        setTitle(event.target.value)
    }
    const handleChangeDescription = (event) => {
        setDescription(event.target.value)
    }
    const handleChangePhoto = (event) => {
        setPhoto(event.target.value)
    }
    const handleChangePrice = (event) => {
        setPrice(event.target.value)
    }
    const handleChangeCategory = (event) => {
        setCategory(event.target.value);
    };

    const EditProduct = (event) => {
        event.preventDefault();
        if (title !== "" && description !== "" && photo !== "" && price !== "" && category > 0 && idProduct > 0) {
            let product = {
                title: title,
                description: description,
                photo: photo,
                price: price,
                category_id: category
            }
            PUT_EDIT_PRODUCT(`products/${idProduct}`, product).then(item => {
                if (item.data === 1) {
                    setCheckUpdate(true);
                }
            })
        }
        else {
            Alert("Bạn chưa nhập đủ thông tin!");
        }
    }
    if (checkUpdate) {
        return <Redirect to="/" />
    }
    return (
        <div className={classes.root}>
            <Grid container spacing={3}>
                <Grid item xs={12}>
                    <Paper className={classes.paper}>
                        <Typography className={classes.title} variant="h4">
                            Edit Product
                        </Typography>
                        <Grid item xs={12} sm container>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitlel">
                                    Title
                                </Typography>
                                <TextField id="Title" onChange={handleChangeTitle} value={title} name="Title"
                                    variant="outlined" className={classes.txtInput} size="small" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitlel">
                                    Description
                                </Typography>
                                <TextField id="outlined-multiline-static" onChange={handleChangeDescription} defaultValue={description}
                                    name="Description" className={classes.txtInput} multiline rows={4} variant="outlined" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitlel">
                                    Photo
                                </Typography>
                                <TextField id="Photo" onChange={handleChangePhoto} value={photo} name="Photo"
                                    variant="outlined" className={classes.txtInput} size="small" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitlel">
                                    Price
                                </Typography>
                                <TextField id="Price" onChange={handleChangePrice} value={price} name="Price"
                                    variant="outlined" className={classes.txtInput} size="small" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitlel">
                                    Choose Category
                                </Typography>
                                <TextField
                                    id="outlined-select-currency-native"
                                    name="idCategory"
                                    select
                                    value={category}
                                    onChange={handleChangeCategory}
                                    SelectProps={{
                                        native: true,
                                    }}
                                    helperText=" "
                                    variant="outlined"
                                    className={classes.txtInput}
                                >
                                    <option value="0">Choose category</option>
                                    {categories.length > 0 && categories.map((option) => (
                                        <option key={option.id} value={option.id}>
                                            {option.title}
                                        </option>
                                    ))}
                                </TextField>

                                
                            </Grid>
                            <Grid item xs={12}>
                                <Button type="button" onClick={EditProduct} fullWidth variant="contained" color="primary"
                                    className={classes.submit} >
                                    Update product
                                </Button>
                            </Grid>
                        </Grid>
                    </Paper>
                </Grid>
            </Grid>
        </div>
    )
}