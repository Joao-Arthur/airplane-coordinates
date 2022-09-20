type params = {
    title: string;
    name: string;
}

export function Input({ title, name, }: params) {
    return (
        <>
            <label
                className="block text-xs font-medium text-gray-500"
                htmlFor={name}
            >
                {title}
            </label>
            <input
                className="w-full p-3 mt-1 text-sm border-2 border-gray-200 rounded"
                name={name}
                type="number"
            />
        </>
    )
}