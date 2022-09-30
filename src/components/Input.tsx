import { ChangeEvent } from 'react';

type props = {
    readonly title: string;
    readonly name: string;
    readonly value: number;
    readonly onChange: (newValue: number) => void;
}

export function Input({ title, name, value, onChange }: props) {
    function handleChange(e: ChangeEvent<HTMLInputElement>) {
        onChange(Number(e.target.value));
    }

    return (
        <>
            <label
                className='block text-xs font-medium text-gray-500'
                htmlFor={name}
            >
                {title}
            </label>
            <input
                className='w-full p-3 mt-1 text-sm border-2 border-gray-200 rounded'
                name={name}
                type='number'
                value={value}
                onChange={handleChange}
            />
        </>
    );
}
