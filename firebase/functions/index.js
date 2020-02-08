const functions = require('firebase-functions');
const express = require('express');
const cors = require('cors');

const app = express();
app.use(express.json());

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions

exports.helloWorld = functions.https.onRequest((request, response) => {
    response.send("Hello from Firebase!");
});

app.post('/sum', (request, response) => {
    // { "sum" : 5 }
    const a = request.body.a;
    const b = request.body.b;
    response.json({
        sum: a+b
    });  
});

app.post('/sub', (request, response) => {
    const a = request.body.a;
    const b = request.body.b;
    response.json({
        sub: a-b
    });  
});

app.post('/div', (request, response) => {
    const a = request.body.a;
    const b = request.body.b;
    response.json({
        div: a/b
    });  
});

app.post('/mult', (request, response) => {
    const a = request.body.a;
    const b = request.body.b;
    response.json({
        mult: a*b
    });  
});

app.get('/about', (request, response) => {
    response.json({
        about: "an application to study POST and GET methods of HTTP protocol",
        version: "1.0.0"
    });
});

exports.widgets = functions.https.onRequest(app);
