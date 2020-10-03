public class UseCaseBus {
    // HashMap<Keyの型, Valueの型>の形式、連想配列
    private final HashMap<Class, Class> handlerTypes = new HashMap<>();
    private final HashMap<Class, UseCaseInvoker> invokers = new HashMap<>();

    private ServiceProvider provider;
    private UseCaseInvokerFactory invokerFactory;

    UseCaseBus(){ }

    public <TInputData extends InputData<TOutputData>,  TOutputData extends OutputData> TOutputData handle(TInputData inputData){
        UseCaseInvoker invoker = getInvoker(inputData);
        return invoker.invoke(inputData);
    }

    void setup(ServiceProvider provider, UseCaseInvokerFactory invokerFactory){
        this.provider = provider;
        this.invokerFactory = invokerFactory;
    }

    <TInputData, TInteractor> void register(Class<TInputData> inputDataClazz, Class<TInteractor> outputDataClazz) {
        handlerTypes.put(inputDataClazz, outputDataClazz);
    }

    private <TOutputData extends OutputData> UseCaseInvoker getInvoker(InputData<TOutputData> inputData) {
        // <? extends InputData>:InputDataのすべてのサブクラス
        Class<? extends InputData> inputDataClazz = inputData.getClass();

        UseCaseInvoker invoker = invokers.getOrDefault(inputDataClazz, null);
        if(handlerClazz == null){
            throw new RuntimeException("not registerd");
        }

        invoker = invokerFactory.generate(handlerClazz, provider);
        invokers.put(inputDataClazz, invoker);
        return invoker;
    }
}
