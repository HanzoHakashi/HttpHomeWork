<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Calendar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <form action="/logout" method="post">
            <a class="navbar-brand" href="/logout"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </form>
    </div>
</nav>
<div class="container">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Понедельник</th>
            <th scope="col">Вторник</th>
            <th scope="col">Среда</th>
            <th scope="col">Четверг</th>
            <th scope="col">Пятница</th>
            <th scope="col">Суббота</th>
            <th scope="col">Воскресенье</th>
        </tr>
        </thead>


        <>
        <tr>
            <td></td>
            <td></td>

            <#list days as day>
            <#if day.day.getDayOfWeek().getValue() == 1> <tr> </#if>
            <td>${day.day}
                <#list day.tasks as task>
                <p>${task.type}
                </#list> </p>
                <form action="/calendar" method="post" class="flex flex-col align-center">
                    <input name="dayId" type="hidden" value=${day.day.getDayOfMonth()}>
                    <button type="submit" class="flex align-center">Перейти в просмотр заданий</button></form></td>


        <#if day.day.getDayOfWeek().getValue() == 7> </tr> </#if>
        </#list>


        </tbody>

    </table>
</div>
</body>

</html>