import classNames from 'classnames';

type props = {
    readonly title: string;
}

export function Button({ title }: props) {
    return (
        <button
            className={
                classNames(
                    'w-full inline-block py-3 text-sm text-center font-medium focus:outline-none rounded border-2',
                    'text-white hover:text-cyan-500 active: active:text-cyan-500',
                    'bg-cyan-500 hover:bg-cyan-100 active:bg-cyan-100',
                    'border-cyan-500 hover:border-cyan-500 active:border-cyan-500',
                    'mt-4',
                )
            }
        >
            {title}
        </button>
    );
}
