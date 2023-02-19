<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Journal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1> Journal</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Book</th>
            <th scope="col">Employee</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <#list journals as journal>
        <tr>
            <td>${journal.book.getName()}</td>
            <#if journal.textStatus = "Книга имеется в наличие">
            <td> </td>
            <#else>
            <td>${journal.employee.getFirstname()}</td>
            </#if>
            <td>${journal.textStatus}</td>
            <td><a type="button" class="btn btn-danger" href="/journal/bookInfo">BookInfo</a></td>
        </tr>
    </#list>
    <tbody>

    </tbody>


    </table>

</div>
</body>
</html>