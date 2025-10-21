@param casino.AppUser currentUser

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
<body class="bg-slate-600 text-white h-screen flex items-center justify-center">

<header class="fixed top-0 w-full bg-gray-900 text-white py-4 px-6 flex items-center justify-between">
    <a href="/">
        <div class="flex items-center space-x-4">
            <img src="/Assets/stakz.svg" alt="Stakz Logo" class="h-10 w-10">
            <h1 class="text-2xl font-bold">Stakz</h1>
        </div>
    </a>

    @if(currentUser == null)
        <!--
        <a href="/login">
            <button class="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded transition duration-300">
                Login
            </button>
        </a>
        -->
        <form class="flex gap-4" action="/login" method="POST">
            <input name="username" type="text" required class="m-none appearance-none relative px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm" placeholder="Username">
            <input name="password" type="password" required class="m-none appearance-none relative px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm" placeholder="Password">

            <button type="submit" class="group relative flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                Sign in
            </button>
        </form>
    @else
        <div class="flex">
            <p class="self-center mr-5">Balance: ${currentUser.getBalance()}</p>
            <p class="self-center mr-5">Welcome ${currentUser.getUsername()}!</p>
            <a href="/logout">
                <button class="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded transition duration-300">
                    Log out
                </button>
            </a>
        </div>
    @endif
</header>

<main class="flex flex-wrap gap-4 max-w-3xl mt-10 mx-auto">
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 1
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 2
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 3
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 4
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 5
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 6
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 7
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 8
    </div>
    <div class="flex-1 min-w-[200px] bg-black p-4 rounded-lg">
        Item 9
    </div>
</main>

<!--
<footer>

</footer>
-->

</body>
</html>