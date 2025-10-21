@param String username

@template.layout.default(content = @`
    <center>
        <h1 class="text-2xl font-medium">Hello World!</h1>

        @if(username == "anonymousUser")
            <!--
            <a href="/login">
                <button type="submit" class="group relative w-10em flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                    Log in
                </button>
            </a>
            -->
        @else
            <p class="text-xl font-medium">Welcome ${username}</p>
            <a href="/logout">
                <button type="submit" class="group relative w-10em flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                    Log Out
                </button>
            </a>
        @endif
    </center>
`)