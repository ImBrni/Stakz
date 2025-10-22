@param casino.model.AppUser currentUser

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
    <link href="https://cdn.jsdelivr.net/npm/flowbite@3.1.2/dist/flowbite.min.css" rel="stylesheet" />
    <script defer src="https://cdn.jsdelivr.net/npm/flowbite@3.1.2/dist/flowbite.min.js"></script>
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
        <form class="flex gap-4 mr-8" action="/signin" method="POST">
            <input name="username" type="text" required class="m-none appearance-none relative px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm" placeholder="Username">
            <input name="password" type="password" required class="m-none appearance-none relative px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm" placeholder="Password">

            <button type="submit" class="group relative flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                Sign in
            </button>
        </form>
    @else
        <!--
        <div class="flex">
            <p class="self-center mr-5">Balance: ${currentUser.getBalance()}</p>
            <p class="self-center mr-5">Welcome ${currentUser.getUsername()}!</p>
            <a href="/logout">
                <button class="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded transition duration-300">
                    Log out
                </button>
            </a>
        </div>
        -->

        <button id="dropdownInformationButton" data-dropdown-toggle="dropdownInformation" class="text-white mr-8 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">Account <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
            </svg>
        </button>

        <div id="dropdownInformation" class="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow-sm w-44 dark:bg-gray-700 dark:divide-gray-600">
            <div class="capitalize flex flex-col justify-center align-center font-bold px-4 py-3 text-sm text-gray-900 dark:text-white">
                <div>${currentUser.getUsername()}</div>
                <div class="font-medium truncate mt-4">Balance: <div class="font-bold">${currentUser.getBalanceFmt()}</div></div>
            </div>
            <ul class="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownInformationButton">
                <li>
                    <a href="/dashboard" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Dashboard</a>
                </li>
                <li>
                    <a href="/rejuice" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Rejuice</a>
                </li>
                <!--
                <li>
                    <a href="#" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Settings</a>
                </li>
                <li>
                    <a href="#" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Earnings</a>
                </li>
                -->
            </ul>
            <div class="py-2">
                <a href="signout" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Sign out</a>
            </div>
        </div>


        <!--------------------->
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