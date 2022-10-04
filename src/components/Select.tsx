import { ChangeEvent, FocusEvent, ForwardedRef, forwardRef } from 'react';

type optionType = {
    readonly name: string;
    readonly label: string;
}

type props = {
    readonly title: string;
    readonly name: string;
    readonly options: readonly optionType[];
    readonly onChange: (e: ChangeEvent<HTMLSelectElement>) => void;
    readonly onBlur: (e: FocusEvent<HTMLSelectElement, Element>) => void;
    readonly required?: boolean;
}

type refType = {
    readonly forwardedRef: ForwardedRef<HTMLSelectElement>
};

function SelectComp({ title, name, options, forwardedRef, onChange, onBlur, required }: props & refType) {
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
                ref={forwardedRef}
                onChange={onChange}
                onBlur={onBlur}
                required={required}
            >
                {options.map(({ name, label }) => (
                    <option key={name} value={name}>{label}</option>
                ))}
            </select>
        </div>
    );
}

// eslint-disable-next-line @typescript-eslint/naming-convention
export const Select = forwardRef<HTMLSelectElement, props>((props, ref) => (
    <SelectComp {...props} forwardedRef={ref} />
));

Select.displayName = 'Input';
