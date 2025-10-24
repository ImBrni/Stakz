@param casino.model.AppUser currentUser

<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)

<main class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">
    <div class="table p-4 bg-green-900 text-green-900 w-2/3 max-w-[1000px] h-1/2 rounded-xl">
        Table
    </div>

    <div class="controls flex gap-6 justify-center max-w-[1000px] items-center h-1/6 w-1/2">
        <div class="max-w-[300px]">
            @template.modules.nbutton(label = "Start Game")
        </div>
    </div>
</main>

@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>