const express = require('express');
const app = express();
const port = 3000;
const path = require('path'); 
app.set('view engine', 'ejs');
app.use(express.urlencoded({ extended: true }));

app.get('/greet', (req, res) => {
  res.render('greet')
});


app.post('/greet', (req, res) => {
  const { firstName, lastName } = req.body;
  res.render('welcome', { firstName, lastName });
});

app.get('/course', (req, res) => {
  res.render("courseForm")  });

  app.post('/courses', (req, res) => {
    const courses = req.body.courses;

    const coursesList = Array.isArray(courses) ? courses : [courses];

    res.render('courses', { coursesList });
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
