@param casino.model.AppUser currentUser
@param boolean enabled

<!--
<div class="fixed bottom-10">
  <span class="inline-flex divide-x divide-gray-300 overflow-hidden rounded border border-gray-300 bg-white shadow-sm dark:divide-gray-600 dark:border-gray-600 dark:bg-gray-800">
    <div class="px-3 py-1.5 text-2xl font-medium text-gray-700 dark:text-gray-200">
      10,000 $
    </div>

    <button type="button" class="px-3 py-1.5 text-gray-700 transition-colors hover:bg-gray-50 hover:text-gray-900 focus:relative dark:text-gray-200 dark:hover:bg-gray-700 dark:hover:text-white" aria-label="Menu">
      <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="4" stroke="currentColor" class="size-4">
        <path stroke-linecap="round" stroke-linejoin="round" d="m19.5 8.25-7.5 7.5-7.5-7.5"/>
      </svg>
    </button>
  </span>

    <div role="menu" class="absolute end-0 -top-[200px] z-auto w-56 overflow-hidden rounded border border-gray-300 bg-white shadow-sm dark:border-gray-600 dark:bg-gray-800">
        <a href="#" class="block px-3 py-2 text-sm font-medium text-gray-700 transition-colors hover:bg-gray-50 hover:text-gray-900 dark:text-gray-200 dark:hover:bg-gray-700 dark:hover:text-white" role="menuitem">
            Storefront
        </a>

        <a href="#" class="block px-3 py-2 text-sm font-medium text-gray-700 transition-colors hover:bg-gray-50 hover:text-gray-900 dark:text-gray-200 dark:hover:bg-gray-700 dark:hover:text-white" role="menuitem">
            Warehouse
        </a>

        <a href="#" class="block px-3 py-2 text-sm font-medium text-gray-700 transition-colors hover:bg-gray-50 hover:text-gray-900 dark:text-gray-200 dark:hover:bg-gray-700 dark:hover:text-white" role="menuitem">
            Stock
        </a>

        <button type="button" class="block w-full px-3 py-2 text-left text-sm font-medium text-red-700 transition-colors hover:bg-red-50 dark:text-red-600 dark:hover:bg-red-700/20">
            Delete
        </button>
    </div>
</div>
-->

@if(enabled)
@if(currentUser != null)
<div class="sm:hidden fixed bottom-10 px-4 py-2 font-bold border bg-gray-900 rounded-md text-xl flex justify-center content-center ">
    ${currentUser.getBalanceFmt()} $
</div>
@endif
@endif