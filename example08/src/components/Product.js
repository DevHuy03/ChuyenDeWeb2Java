import React, { useEffect, useState } from 'react'
import { makeStyles } from '@mui/styles';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Alert from '@mui/material/Alert';
import { Redirect } from 'react-router-dom';
import { GET_ALL_CATEGORIES, POST_ADD_PRODUCT } from '../api/apiService';

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
        width: '98%'
        ,
        margin: '1%'
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
}));
const currencies = [

    {
        value: 'USD',
        label: '$',
    },

    {
        value: 'EUR',
        label: '€',
    },

    {
        value: 'BTC',
        label: '',
    },
    {
        value: 'JPY',
        label: '¥',
    },
];
export default function Product() {
    const classes = useStyles();
    const [checkAdd, setCheckAdd] = useState(false);
    const [title, setTitle] = useState(null)
    const [description, setDescription] = useState(null)
    const [photo, setPhoto] = useState(null)
    const [price, setPrice] = useState(null)
    const [category, setCategory] = useState(0);
    const [categories, setCategories] = useState({});
    useEffect(() => {
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
    const addProduct = (event) => {

        
        event.preventDefault();
        if (title !== "" && description !== "" && price !== "" && photo !== "" && category > 0) {
            let product = {
                title: title,
                description: description,
                price: price,
                photo:photo,
                category_id: category
            }
            POST_ADD_PRODUCT(`products`, product).then(item => {
                if (item.data === 1) {
                    setCheckAdd(true);
                }
            })
        }
        else {
            alert("Bạn chưa nhập đủ thông tin!");
        }
        
    }
    if (checkAdd) {
        return <Redirect to="/" />
    }

    return (
        <div className={classes.root}>
            <Grid container spacing={3}>
                <Grid item xs={12}>
                    <Paper className={classes.paper}>
                        <Typography className={classes.title} variant="h4">
                            Add Product
                        </Typography>
                        <Grid item xs={12} sm container>
                            <Grid item xs={12}><Typography gutterBottom variant="subtitle1">
                                Title
                            </Typography>
                                <TextField id="Title" onChange={handleChangeTitle} name="Title" label="Title"
                                    variant="outlined" className={classes.txtInput} size="small" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitle1">
                                    Description
                                </Typography>
                                <TextField id="outlined-multiline-static" onChange={handleChangeDescription} label="Description"
                                    name="Description" className={classes.txtInput} multiline rows={4} defaultValue="Description" variant="outlined" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitle1">
                                    Price
                                </Typography>
                                <TextField id="Price" onChange={handleChangePrice} name="Price" label="Price"
                                    variant="outlined" className={classes.txtInput} size="small" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitle1">
                                    Photo
                                </Typography>
                                <TextField id="photo" onChange={handleChangePhoto} name="photo" label="photo"
                                    variant="outlined" className={classes.txtInput} size="small" />
                            </Grid>
                            <Grid item xs={12}>
                                <Typography gutterBottom variant="subtitle1">
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
                                <Button type="button" onClick={addProduct} fullWidth variant="contained" color="primary"
                                    className={classes.submit} >
                                    Add product
                                </Button>
                            </Grid>
                        </Grid>
                    </Paper>
                </Grid>
            </Grid>
        </div>
    )
}
