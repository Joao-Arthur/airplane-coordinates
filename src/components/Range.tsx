import { ChangeEvent, FocusEvent, ForwardedRef, forwardRef } from 'react';

type props = {
    readonly title: string;
    readonly name: string;
    readonly onChange: (e: ChangeEvent<HTMLInputElement>) => void;
    readonly onBlur: (e: FocusEvent<HTMLInputElement, Element>) => void;
    readonly required?: boolean;
}

type refType = {
    readonly forwardedRef: ForwardedRef<HTMLInputElement>;
};

function RangeComp({
    title,
    name,
    forwardedRef,
    onChange,
    onBlur,
    required,
}: props & refType) {
    return (
        <div className='px-2 min-w-0 w-full'>
            <label
                className='block text-xs font-medium text-gray-500'
                htmlFor={name}
            >
                {title}
            </label>
            <input
                className='w-full p-3 mt-1 text-sm border-2 border-gray-200 rounded'
                name={name}
                type='range'
                step={1}
                min={2}
                max={50}
                ref={forwardedRef}
                onChange={onChange}
                onBlur={onBlur}
                required={required}
            />
        </div>
    );
}

// eslint-disable-next-line @typescript-eslint/naming-convention
export const Range = forwardRef<HTMLInputElement, props>((props, ref) => (
    <RangeComp {...props} forwardedRef={ref} />
));

Range.displayName = 'Range';
