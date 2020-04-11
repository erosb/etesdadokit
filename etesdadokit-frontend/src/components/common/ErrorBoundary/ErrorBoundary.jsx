import React from 'react'
import log from 'loglevel'
import PropTypes from 'prop-types'

class ErrorBoundary extends React.Component {
    constructor(props) {
        super(props)
        const { hasError, error, errorInfo, componentName } = props
        this.logger = log.getLogger('Marc-Editor-Logger')
        this.state = {
            hasError: hasError || false,
            error: error || null,
            errorInfo: errorInfo || null,
            componentName: componentName || '',
        }
    }

    componentDidCatch(error, errorInfo) {
        this.setState(
            () => ({
                hasError: true,
                error,
                errorInfo,
            }),
            () => {
                const logMessage = {
                    error,
                    componentStack: errorInfo.componentStack,
                    toString: `Logger error message:\n Date: ${new Date()}\n Error: ${error.toString()}\n
 ComponentStack: ${errorInfo.componentStack}`,
                }
                this.logger.error(logMessage)
            }
        )
    }

    render() {
        const { hasError, error, errorInfo, componentName } = this.state
        const { children } = this.props
        const componentStack = errorInfo && errorInfo.componentStack ? errorInfo.componentStack : ''
        if (hasError) {
            return (
                <div className="marc-editor-error-alert">
                    <h1>Something went wrong with {componentName}</h1>
                    <details style={{ whiteSpace: 'pre-wrap' }}>
                        {error && error.toString()}
                        <br />
                        {componentStack}
                    </details>
                </div>
            )
        }

        return children
    }
}

export default ErrorBoundary

ErrorBoundary.propTypes = {
    hasError: PropTypes.bool,
    error: PropTypes.string,
    errorInfo: PropTypes.shape(),
    children: PropTypes.node.isRequired,
    componentName: PropTypes.string,
}

ErrorBoundary.defaultProps = {
    hasError: false,
    error: '',
    errorInfo: null,
    componentName: '',
}