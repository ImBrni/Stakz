@param casino.model.AppUser currentUser

<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)

<main class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">
    <div class="table bg-green-900 w-2/3 max-w-[1000px] h-1/2 rounded-[100%]">
        Table
    </div>
</main>

@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>