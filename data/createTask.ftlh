<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CreateTask</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Cоздание задачи ${day}</h1>
    <form action="/createTask" method="post">
        <fieldset>
            <div class="form-element">
                <label for="name">email</label>
                <input type="name" name="name" id="name" placeholder="Name of Task" required autofocus>
            </div>
            <div class="form-element">
                <label for="desc">password</label>
                <input type="text" name="desc" id="desc" placeholder="Description" required>
            </div>
            <div class="input-group">
                <select class="form-select" id="type" aria-label="Example select with button addon" name="type">
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>
            <div class="form-element">
                <button class="register-button" type="submit">Создать задачу!</button>
            </div>
        </fieldset>
    </form>




</div>

</body>
</html>