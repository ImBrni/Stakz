@param casino.model.AppUser currentUser
@param boolean enabled = true

@if(enabled)
@if(currentUser != null)
<div class="sm:hidden fixed bottom-10 px-4 py-2 font-bold border bg-gray-900 rounded-md text-xl flex justify-center content-center ">
    ${currentUser.getBalanceFmt()} $
</div>
@endif
@endif