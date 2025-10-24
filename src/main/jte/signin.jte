@param casino.model.AppUser currentUser

<!DOCTYPE html>
<html lang="en">
@template.modules.head()
<body>

@template.modules.header(currentUser = currentUser, enabled = false)

<main class="flex flex-wrap gap-4 min-w-[300px] w-1/4 mx-auto">
    <div class="min-h-screen w-full flex items-center justify-center">
        <div class="max-w-md w-full space-y-8 p-8 bg-white rounded-lg shadow-md">
            <div>
                <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
                    Sign in
                </h2>
            </div>

            <form class="mt-8 space-y-6" action="/signin" method="POST">
                <div class="rounded-md shadow-sm -space-y-px">
                    <div>
                        <input name="username" type="text" required
                               class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                               placeholder="Username">
                    </div>
                    <div>
                        <input name="password" type="password" required
                               class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 sm:text-sm"
                               placeholder="Password">
                    </div>
                </div>

                <div>
                    @template.modules.button(label = "Sign in", uri = "/signin", colored = true, type = "submit")
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