import { ChangeEvent } from "react";

type props = {
    title: string;
    name: string;
    options: {
        name: string;
        label: string;
    }[];
    value: string;
    onChange: (newValue: string) => void;
}

export function Select({ title, name, options, value, onChange }: props) {
    function handleChange(e: ChangeEvent<HTMLSelectElement>) {
        onChange(e.target.value);
    }

    return (
        <>
            <label
                className="block text-xs font-medium text-gray-500"
                htmlFor={name}
            >
                {title}
            </label>
            <select
                className="w-full p-3 mt-1 text-sm border-2 border-gray-200 rounded"
                name={name}
                value={value}
                onChange={handleChange}
            >
                {options.map(({ name, label }) => <option value={name}>{label}</option>)}
            </select>
        </>
    )
}