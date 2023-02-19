<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BookInfo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="card" style="width: 18rem;">
        <img src="https://upload.wikimedia.org/wikipedia/ru/b/b7/Berserk_Vol._1.png" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${book.name}</h5>
            <h6 class="card-title">${book.author}</h6>
            <p>${book.genre}</p>
            <p>${book.year}</p>
            <p class="card-text">«Берсерк» — фэнтези-манга, автором которой является Кэнтаро Миура. Первый том был издан в 1989 году. Согласно опросу, проведённому в 2007 году министерством культуры Японии, занимает 25-е место среди лучшей манги всех времён.</p>
        </div>
    </div>

</div>
</body>
</html>