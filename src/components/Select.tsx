import { ChangeEvent } from 'react';

type optionType = {
    readonly name: string;
    readonly label: string;
}

type props = {
    readonly title: string;
    readonly name: string;
    readonly options: readonly optionType[];
    readonly value: string;
    readonly onChange: (newValue: string) => void;
}

export function Select({ title, name, options, value, onChange }: props) {
    function handleChange(e: ChangeEvent<HTMLSelectElement>) {
        onChange(e.target.value);
    }

    return (
        <div className='p-2'>
            <label
                className='block text-xs font-medium text-gray-500'
                htmlFor={name}
            >
                {title}
            </label>
            <select
                className='w-full p-3 mt-1 text-sm border-2 border-gray-200 rounded'
                name={name}
                value={value}
                onChange={handleChange}
            >
                {options.map(({ name, label }) => (
                    <option key={name} value={name}>{label}</option>
                ))}
            </select>
        </div>
    );
}
