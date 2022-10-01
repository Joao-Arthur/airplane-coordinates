import classNames from 'classnames';

type props = {
    readonly title: string;
    readonly onClick: () => void;
}

export function Button({ title, onClick }: props) {
    return (
        <button
            className={
                classNames(
                    'w-full inline-block py-3 text-sm text-center font-medium focus:outline-none rounded border-2',
                    'text-white hover:text-indigo-500 active: active:text-indigo-500',
                    'bg-indigo-500 hover:bg-indigo-100 active:bg-indigo-100',
                    'border-indigo-500 hover:border-indigo-500 active:border-indigo-500',
                    'mt-4',
                )
            }
            onClick={onClick}
        >
            {title}
        </button>
    );
}
