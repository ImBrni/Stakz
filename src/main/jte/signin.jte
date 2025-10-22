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
</header>

<main class="flex flex-wrap gap-4 max-w-3xl mt-10 mx-auto">
    <div class="min-h-screen flex items-center justify-center">
        <div class="max-w-md w-full space-y-8 p-8 bg-white rounded-lg shadow-md">
            <div>
                <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
                    Sign in
                </h2>
            </div>

            <!-- Login Form -->
            <form class="mt-8 space-y-6" action="/signin" method="POST">
                <div class="rounded-md shadow-sm -space-y-px">
                    <div>
                        <input name="username" type="text" required
                               class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                               placeholder="Username">
                    </div>
                    <div>
                        <input name="password" type="password" required
                               class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                               placeholder="Password">
                    </div>
                </div>

                <div>
                    <button type="submit"
                            class="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                        Sign in
                    </button>
                </div>
            </form>
        </div>
    </div>
</main>

<!--
<footer>

</footer>
-->

</body>
</html>