<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Vote for us!</title>
    <link rel="stylesheet" href="css/candidates.css">
</head>

<body>
    <div class="container flex flex-col align-center">
    <h1>Vote for us</h1>
    <main class="flex flex-wrap align-evenly">
    <div class="card">
      <form action="/vote" method="post" class="flex flex-col align-center">
          <#list candidates as candidate>
          <img src="/images/1.jpg">
         <p> ${candidate.candidateID?starts_with("1")?string("candidate.name", "no")}</p>
        <input name="candidateId" type="hidden" value="1">
        <button type="submit" class="vote flex align-center">Vote</button>
      </form>
    </div>
    <div class="card">
      <form action="/vote" method="post" class="flex flex-col align-center" href="#">
        <img src="/images/2.jpg">
        <p>name surname</p>
        <input name="candidateId" type="hidden" value="candidate_id">
        <button type="submit" class="vote flex align-center">Vote</button>
      </form>
    </div>
    <div class="card">
      <form action="/vote" method="post" class="flex flex-col align-center" href="#">
          <img src="/images/3.jpg">
        <p>name surname</p>
        <input name="candidateId" type="hidden" value="candidate_id">
        <button type="submit" class="vote flex align-center">Vote</button>
      </form>
    </div>
        <div class="card">
            <form action="/vote" method="post" class="flex flex-col align-center">
                <img src="/images/4.jpg">
                <p>name surname</p>
                <input name="candidateId" type="hidden" value="candidate_id">
                <button type="submit" class="vote flex align-center" >Vote</button>
            </form>
        </div>
        <div class="card">
            <form action="/vote" method="post" class="flex flex-col align-center" href="#">
                <img src="/images/5.jpg">
                <p>name surname</p>
                <input name="candidateId" type="hidden" value="candidate_id">
                <button type="submit" class="vote flex align-center">Vote</button>
            </form>
        </div>
        <div class="card">
            <form action="/vote" method="post" class="flex flex-col align-center" href="#">
                <img src="/images/6.jpg">
                <p>name surname</p>
                <input name="candidateId" type="hidden" value="candidate_id">
                <button type="submit" class="vote flex align-center">Vote</button>
            </form>
        </div>
    </main>
    
      <p>-------------------------------------------------------</p>
      <a class="back flex align-center" href="/votes">Show total votes</a>
    </div>
<div>
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
</div>
</body>

</html>