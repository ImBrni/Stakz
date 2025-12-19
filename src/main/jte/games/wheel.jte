@param casino.model.AppUser currentUser

<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)

<main class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">

</main>

@template.modules.footer(currentUser = currentUser, enabled = true)

<div class="bottom-5 absolute text-zinc-700">Made By Hegedűs János</div>

</body>
</html>