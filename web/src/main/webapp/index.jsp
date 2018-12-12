<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web Applications Development Assignment</title>
    <style>
        /*Style elements of body.*/
        body{
            background: lightseagreen;
            font-family: "Times New Roman", Times, serif;
        }
        /*Style elements of links*/
        a:Link{
            color:white;
            text-decoration: none;
        }
        a:visited{
            color:white;
            text-decoration: none;
        }
        /*Style elements of basic buttons.*/
        #button_div{
            display: block;
            text-align: center;
        }
        button{
            background-color: lightseagreen;
            color: white;
            padding: 12px 20px;
            display: inline-block;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-family: "Times New Roman", Times, serif;
            text-align: center;
            font-size: 15px;
            transition-duration: 0.5s;
        }
        button:HOVER{
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
        }
        /*Style elements of main body, menu bar and the title.*/
        #everything{
            margin: auto;
            width: 100%;
            alignment: center;
        }
        #banner{
            height: 60px;
            margin: 0px 50px 0px 50px;
            font-size: 80px;
            color: white;
            text-align: center;
        }
        #menuBar{
            margin-top: 40px;
            background: lightblue;
            font-size: 17px;
            font-family: "Arial", sans-serif;
            alignment: center;
            border-radius: 20px;
        }
        #menuBar .menuButton{
            width: 160px;
            height: 20px;
            background: gray;
            border: 2px solid black;
            padding: 10px auto;
            text-align: center;
            color: gray;
            margin: 20px;
            -webkit-border-radius: 20px;
            -moz-border-radius: 20px;
            border-radius: 20px;
            cursor: pointer;
            display: inline-block;
            transition-duration: 0.5s;
            font-size: 15px;
        }
        #menuBar .menuButton:HOVER{
            background-color: black;
            border: 2px solid grey;
        }
        /*Style elements of the loaded content HTMLs in general.*/
        #content_outer{
            border-radius: 20px;
            background: lightblue;
            margin-top: 100px;
            margin-left: 50px;
            margin-right: 50px;
        }
        #content{
            text-align: justify;
            margin-left: 20px;
            margin-right: 20px;
        }
        /*Style elements of the assignment description titles.*/
        #header{
            text-align: left;
            font-size: 45px;
            color: darkslategrey;
        }
        /*Style elements of the assignment description div.*/
        #Description{
            display: none;
            padding-bottom: 5px;
        }
        #readme{
            text-align: center;
            margin-top: 20px;
        }
        /*Style elements of authentication.*/
        #author{
            text-align: center;
            padding-top: 5px;
            color: darkslategray;
            font-size: 10px;
            font-family: "Arial", sans-serif;
        }
        /*Animation keyframes.*/
        @-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
        @-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
        @keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
        /*Animation creation.*/
        .fade-in {
            /*Making things invisible upon start*/
            opacity:0;
            /*Calling keyframe named fadeIn, using animation ease-in and repeat it only 1 time*/
            -webkit-animation:fadeIn ease-in 1;
            -moz-animation:fadeIn ease-in 1;
            animation:fadeIn ease-in 1;
            /*Making sure that after the animation is done it remains at the last keyframe value (opacity: 1)*/
            -webkit-animation-fill-mode:forwards;
            -moz-animation-fill-mode:forwards;
            animation-fill-mode:forwards;

            -webkit-animation-duration:0.7s;
            -moz-animation-duration:0.7s;
            animation-duration:0.7s;
        }
    </style>
    <script>
        $(document).ready(function () {
            $.each($(".menuButton"), function (mbIndex, mbValue) {
                $(mbValue).click(function (event) {
                    event.preventDefault();
                    if (!($(this).find('a').attr("href") === "index.html")) {
                        $("#content").load($(this).find('a').attr("href"));
                    }
                    else {
                        open("index.html", "_self");
                    }
                });
            })
        });

        function Show(button_id) {
            var button_text = document.getElementById(button_id);
            var x = document.getElementById("Description");
            if (button_text.firstChild.data === "Show assignment description")
            {
                button_text.firstChild.data = "Hide assignment description";
                x.style.display = "block";
            }
            else
            {
                button_text.firstChild.data = "Show assignment description";
                x.style.display = "none";
            }
        }
    </script>
</head>

<body>
<div id="everything">
    <div id="banner">
        <div id="menuBar">
            <span class="menuButton"><a href="index.jsp">Home</a></span>
        </div>
        <div>Job database</div>
    </div>
</div>

<div id="content_outer">
    <div id="content">
        <div class="fade-in">
            <div id="readme">
                <p><i>A basic web-server project.</i></p>
            </div>
            <div id="button_div">
                <button id="show" onclick="Show(this.id)">Show assignment description</button>
            </div>

            <div id="Description">
                <div id="header">Assignment description</div>
                <p>Hi! I am Alex Nussbaumer (WLM9W8) and this is my solution for the Web Applications home assignment.
                    In this assignment I had to create a back-end for a basic work advertising page,
                    that can store jobs, applicants and applications. The technologies and tools were used during the project:
                </p>
                <ul>
                    <li>Java, Maven</li>
                    <li>J2EE</li>
                    <li>Spring</li>
                    <li>gitHub</li>
                    <li>Tomcat</li>
                    <li>IntelliJ IDEA</li>
                    <li>Postman</li>
                </ul>
                <div id="header">Notes</div>
                <p><b>Postman request testing collection and REST API documentation is uploaded into the root folder!</b></p>
                <p>
                    The project is far from perfect, it is just a basic example of how these technologies work, and how do we
                    have to use them. I am planning to improve it after the evaluation, to practice more within the subject. My
                    future plans for this project are:
                </p>
                <ul>
                    <li>Designing a proper front-end;</li>
                    <li>Creating user right separations and registration;</li>
                    <li>Creating tests for the implementations;</li>
                    <li>Adding more functions for the right groups;</li>
                    <li>Maybe creating a proper database for it as well.</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div id="author">Made by Alex Nussbaumer, 2018</div>
</body>
</html>