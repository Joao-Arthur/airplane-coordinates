export function MainPage() {
    return (<div className="relative">
        <label className="block text-xs font-medium text-gray-500" for="email"> Email </label>

        <input className="w-full p-3 mt-1 text-sm border-2 border-gray-200 rounded" id="email" type="email" />
    </div>)
}