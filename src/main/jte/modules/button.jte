@param String label
@param String uri = null
@param String type = null

@param String name = ""
@param String value = ""
@param String onclick = ""
@param String customclass = ""

<%--
@param String action = null
@param String method = null
@param String target = null
@param String swap  = null
@param String trigger = null
--%>

<a class="group relative inline-block text-sm font-medium text-white focus:ring-3 focus:outline-hidden" href="${uri}" >
    <button type="${type}" name="${name}" value="${value}" onclick="${onclick}" class="${customclass} w-full">
    <span class="absolute inset-0 border rounded-md border-blue-600"></span>
    <span class="block border border-blue-600 bg-blue-600 hover:bg-blue-700 px-6 py-3 rounded-md transition-transform group-hover:-translate-x-1 group-hover:-translate-y-1">
        ${label}
    </span>
    </button>
</a>
