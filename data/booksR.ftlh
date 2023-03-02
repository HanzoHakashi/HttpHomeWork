<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th scope="col">Name</th>
            <th scope="col">Author</th>
            <th scope="col">Genre</th>
            <th scope="col">Year</th>
        </tr>
        </thead>
        <!--        <tfoot>-->
        <!--        <tr>-->
        <!--            <th scope="col">Name</th>-->
        <!--            <th scope="col">Author</th>-->
        <!--            <th scope="col">Genre</th>-->
        <!--            <th scope="col">Year</th>-->
        <!--        </tr>-->
        <!--        </tfoot>-->


        <tbody>
        <#list books as book>
        <tr>
            <td>${book.bookID}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
            <td>${book.year}</td>
        </tr>
        </#list>
        </tbody>

    </table>
    <div><p>Введите ID нужной книги</p></div>
    <div class="input-group mb-3">
        <form action="/returnBook" method="post">
            <div class="form-element">
                <label for="ID">bookID</label>
                <input type="text" name="bookID" id="ID" placeholder="ID" required>
                <div class="form-element">
                    <button class="register-button" type="submit">Which Book would u like to return!</button>
                </div>
            </div>
        </form>

    </div>
</div>
</body>

</html>