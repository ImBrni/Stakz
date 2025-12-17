@param casino.model.AppUser currentUser

<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)

<main class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">
    <svg height="100" width="100" xmlns="http://www.w3.org/2000/svg">
        <circle r="45" cx="50" cy="50" fill="white" />
    </svg>
</main>

@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>