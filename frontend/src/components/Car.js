import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';

export default function Car() {
    const[modelName,setModelName]=useState('')
    const[cost, setCost]=useState('')
    const[cars, setCars]=useState([])

    const applyClick=(e)=>{
        e.preventDefault()
        const car={modelName, cost}
        console.log(car)
        fetch("http://localhost:8080/car/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(car)

        }).then(()=>{
            console.log("New Car Successfully Added")
        })
    }

    useEffect(()=>{
        fetch("http://localhost:8080/car/getAll")
        .then(res=>res.json())
        .then((result)=>{
            setCars(result)
        }
        )
    },[])

  return (

    <Container>
        <h1>Add Car</h1>
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1,},
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="standard-basic" label="Car Model" variant="standard" fullWidth
      value={modelName}
      onChange={(e)=>setModelName(e.target.value)}
      />
      <TextField id="standard-basic" label="Cost" variant="standard" fullWidth
      value={cost}
      onChange={(e)=>setCost(e.target.value)}
      />
      <Button variant="contained" color="success" onClick={applyClick}>
  Submit
</Button>
    </Box>

    <h1>Cars</h1>

    <Paper elevation={3}>

        {cars.map(car=>(
              <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={car.id}>
                Id:{car.id}<br/>
                modelName:{car.modelName}<br/>
                cost:{car.cost}

            </Paper>
            ))
            }


    </Paper>


    </Container>
  );
}