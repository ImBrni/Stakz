@param String label

@param String action = ""
@param String method = ""
@param String target = ""
@param String swap = ""
@param String trigger = ""

<button class="w-full group relative inline-block text-sm font-medium text-white focus:ring-3 focus:outline-hidden w-full" fx-action="${action}" fx-method="${method}" fx-target="${target}" fx-swap="${swap}" fx-trigger="${trigger}" >
    <span class="absolute inset-0 border rounded-md border-blue-600"></span>
    <span class="block border border-blue-600 bg-blue-600 hover:bg-blue-700 px-6 py-3 rounded-md transition-transform group-hover:-translate-x-1 group-hover:-translate-y-1">
        ${label}
    </span>
</button>