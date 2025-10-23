@param casino.model.AppUser currentUser
@param boolean enabled = true

<header class="fixed top-0 w-full bg-gray-900 text-white py-4 px-6 flex items-center justify-between">
    <a href="/">
        <div class="flex items-center space-x-4">
            <img src="assets/stakz.svg" alt="Stakz Logo" class="h-10 w-10">
            <h1 class="text-2xl font-bold">Stakz</h1>
        </div>
    </a>

    @if(enabled)
    @if(currentUser == null)
        <a href="/signin" class="mr-8">
            <button class="group relative flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                Sign in
            </button>
        </a>
    @else
        <div class="hidden sm:block px-4 py-2 font-bold border rounded-md flex justify-center content-center ">
            ${currentUser.getBalanceFmt()} $
        </div>

        <button id="dropdownInformationButton" data-dropdown-toggle="dropdownInformation" class="capitalize text-white mr-8 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
            ${currentUser.getUsername()}
            <svg class="w-2.5 h-2.5 ms-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4"/>
            </svg>
        </button>

        <div id="dropdownInformation" class="hidden bg-white divide-y divide-gray-100 rounded-lg shadow-sm w-44 dark:bg-gray-700 dark:divide-gray-600">
            <!--
            <div class="capitalize flex flex-col justify-center align-center font-bold px-4 py-3 text-sm text-gray-900 dark:text-white">
                <div>${currentUser.getUsername()}</div>
                <div class="font-medium truncate mt-4">Balance: <div class="font-bold">${currentUser.getBalanceFmt()}</div></div>
            </div>
            -->
            <ul class="py-2 -z-10 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownInformationButton">
                <li>
                    <a href="/" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Home</a>
                </li>
                <li>
                    <a href="/earnings" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Earnings</a>
                </li>
                <li>
                    <a href="/rejuice" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Rejuice</a>
                </li>
            </ul>
            <div class="py-2">
                <a href="signout" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Sign out</a>
            </div>
        </div>
    @endif
    @endif
</header>