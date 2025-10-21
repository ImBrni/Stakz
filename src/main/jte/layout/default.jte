@param gg.jte.Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Stakz</title>
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <meta name="description" content="" />
    <link rel="stylesheet" type="text/css" href="Assets/style.css" />
    <link rel="icon" href="Assets/stakz.svg">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-slate-600 text-white">

<!--
<header>

</header>
-->

<header class="bg-gray-900 text-white py-4 px-6 flex items-center justify-between">
    <a href="/">
    <div class="flex items-center space-x-4">
        <img src="/Assets/stakz.svg" alt="Stakz Logo" class="h-10 w-10">
        <h1 class="text-2xl font-bold">Stakz</h1>
    </div>
    </a>

    <a href="/login">
        <button class="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded transition duration-300">
            Login
        </button>
    </a>
</header>

<main>
${content}
</main>

<!--
<footer>

</footer>
-->

</body>
</html>
