@param String label
@param String uri = null
@param String type = null
@param boolean colored = true

@if(colored)
    <a class="group relative inline-block text-sm font-medium text-white focus:ring-3 focus:outline-hidden w-full" href="${uri}" >
        <button type="${type}" class="w-full">
        <span class="absolute inset-0 border rounded-md border-blue-600"></span>
        <span class="block border border-blue-600 bg-blue-600 hover:bg-blue-700 px-6 py-3 rounded-md transition-transform group-hover:-translate-x-1 group-hover:-translate-y-1">
            ${label}
        </span>
        </button>
    </a>
@else
    <a class="group relative inline-block text-sm font-medium text-white focus:ring-3 focus:outline-hidden" href="${uri}" >
        <button type="${type}">
        <span class="absolute inset-0 border rounded-md border-gray-600"></span>
        <span class="block border border-gray-600 bg-black-600 px-6 py-3 rounded-md transition-transform group-hover:-translate-x-1 group-hover:-translate-y-1">
            ${label}
        </span>
        </button>
    </a>
@endif
