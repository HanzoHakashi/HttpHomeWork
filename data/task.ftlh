<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Task</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Задания на ${day}</h1>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Тип</th>
            <th scope="col">Название</th>
            <th scope="col">Описание</th>
        </tr>
        </thead>


        <tbody>
        <#list tasks as task>
        <tr>
            <td>${task.type}</td>
            <td>${task.name}</td>
            <td>${task.desc}</td>
        </tr>
        </#list>
        </tbody>

    </table>
    <a href="/createTask" class="btn btn-primary stretched-link">Создать задачу</a>

</div>

</body>
</html>